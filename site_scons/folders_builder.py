# -*- coding: utf-8 -*-
"""Builder for all folders

This module provides the builder function for all folders.

"""

import os.path
import subprocess
import time
from datetime import date
import request_session


def check_whitelist(target_dir):
    """Fn to check whitelist. Fn reads contents of site_scons/whitelist.txt
       into a list and check if the target_dir in in the whitelist.

    Args:
        target_dir (string): domain name of LINK.txt file.

    Returns:
        Bool: True. If target_dir is in whitelist.

    """

    # Link white list
    white_file = 'site_scons/whitelist.txt'
    in_list = False
    # Read whitelist into list
    with open(white_file) as whitef:
        for line in whitef:
            # strip comments
            comment_i = line.find("#")
            clean_line = line[:comment_i].strip()
            clean_len = len(clean_line)
            if clean_len > 0 and clean_line in target_dir:
                in_list = True
    # Return answer
    return in_list


def check_link(chal_link, target_dir):
    """Fn to check LINK.txt files. Fn checks the whitelist and if item is not
       present it makes the request to the chal_link, gets the http status
       code and checks for a 200ok.

    Args:
        chal_link  (string) : url to challenge.
        target_dir (string) : target dir to check in whitelist.

    Returns:
        Bool: True. If 200ok.

    """

    # Init valid_resp
    valid_resp = 1
    # Check whitelist
    white_list = check_whitelist(str(target_dir))
    if not white_list:
        # Get HTTP Status code
        stat_code = request_session.get_code(chal_link)
        # Check for valid response
        if stat_code != 200:
            # Exit build with error 1
            print chal_link + " Stat Code not 200 - " + str(stat_code)
        else:
            # 200 ok
            print str(stat_code)
            # Valid response
            valid_resp = 0
    else:
        # whitelist item
        valid_resp = 0
    # Return answer
    return valid_resp


def lang_linters(fname):
    """Fn to check coding standars on differents languages. Fn execs the
       corresponding linters and returns the exit code.

    Args:
        fname (string) : path to file.

    Returns:
        Int: 0. If success.

    """

    # Init out vars
    lint_skip = False
    flake_on = False
    build_result = []
    lint_result = 0
    out_lint = 0
    out_flake = 0
    # File basename
    fbase_name = os.path.basename(fname.rstr())
    # Check python files
    if fbase_name.endswith(".py"):
        # Set out msg
        out_msg = "py lint "
        # Set command
        lint_cmd = ["pylint"]
        # Enable flake
        flake_on = True
        flake_cmd = ["flake8"]
    # Check ruby files
    elif fbase_name.endswith(".rb"):
        # Set out msg
        out_msg = "rb lint "
        # Set command
        lint_cmd = ["ruby-lint"]
    # Check c files
    elif fbase_name.endswith(".c"):
        # Set out msg
        out_msg = "c lint "
        # Set command
        lint_cmd = ["splint"]
    else:
        lint_skip = True
        out_lint = 0
        out_msg = "No linter for this language yet "
    # Prep commands
    str_fname = str(fname)
    lint_cmd.append(str_fname)
    if not lint_skip:
        # Exec command
        try:
            out_lint = subprocess.call(lint_cmd, shell=False)
            if flake_on:
                out_flake = subprocess.call(flake_cmd, shell=False)
                lint_result += abs(out_flake)
        # Handle Errors
        except OSError as oerr:
            print "OSError > ", oerr.errno, " - ", oerr.strerror
            lint_result = 1
    # Calc exit code
    lint_result += abs(out_lint)
    # Prep response
    build_result.append(lint_result)
    build_result.append(out_msg)
    # Return exit code
    return build_result


def build_folders(target, source, env):
    """Fn to build folders. Fn iterates through all files in the folder and
       checks the existence and validity of the LINK file and runs the linters
       on the different files based on their extention.

    Args:
        target    (list): Path to target file.
        source    (list): Path to source file (OTHERS.txt containing URLs).
        env  (SCons.Env): SCons environment from SConstruct.

    Returns:
        Int: 1. For build error.
             0. For successfull build.

    """

    # builder creation date
    born_unix = time.mktime(date(2017, 06, 14).timetuple())
    # Prep directory location
    target_dir = os.path.dirname(str(target[0]))
    target_dir = env.Dir(target_dir)
    target_f = env.File(str(target[0]))
    # Make and open target file to write
    target_file = open(str(target_f), 'w')
    # Init folder build vars
    link_build = 1
    lint_build = 0
    link_exist = False
    # Iterate through folder
    for fname in source:
        # Get file last mod date
        fdate = os.path.getmtime(fname.rstr())
        # Check LINK.txt files
        if os.path.basename(fname.rstr()) == "LINK.txt":
            link_exist = True
            chal_link = str(fname.get_contents())
            link_build = check_link(chal_link, target_dir)
            if link_build == 0:
                target_file.write(chal_link + "- 200" + "\n")
        # Only check files created after builder
        elif fdate > born_unix:
            # Run lang linters
            lint_build = lang_linters(fname)
            if lint_build[0] == 0:
                target_file.write(str(fname) + lint_build[1] + ": success \n")
            else:
                # Linter failed
                exit_code = str(lint_build[0])
                print lint_build[1] + " Failed - exit code: " + exit_code
                # Exit build with errors
                return 1
        else:
            # Omit build for old files
            target_file.write(fname.rstr() + "OLD - omiting linter \n")
    # Close file
    target_file.close()
    target_f = env.File(target_file)
    # Check LINK.txt exist
    if not link_exist:
        print target_file.name[:-10], " - LINK file does not exist - "
        return 1
    # Exit successful build
    return 0
