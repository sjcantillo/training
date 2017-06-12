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


def build_python(fname):
    """Fn to check python sintax. Fn execs flake8 command and pylint command
       and returns the exit code.
    Args:
        fname (string) : path to py file.

    Returns:
        Int: 0. If success.

    """

    # Prep commands
    flake_cmd = ["flake8"]
    str_fname = str(fname)
    flake_cmd.append(str_fname)
    pylint_cmd = ["pylint"]
    pylint_cmd.append(str_fname)
    # Call flake8 and Pylint on python file
    try:
        out_flake = subprocess.call(flake_cmd, shell=False)
        out_plint = subprocess.call(pylint_cmd, shell=False)
    # Handle Errors
    except OSError as oerr:
        print "OSError > ", oerr.errno, " - ", oerr.strerror
        out_flake = 1
        out_plint = 1
    # Sum absolute value of exit codes
    output = abs(out_flake) + abs(out_plint)
    # Return combined exit code
    return output


def check_builds(build_list):
    """Fn to check the result of the different builds. Fn iterates through the
    given dictionary of build outputs and checks if they are 0.

    Args:
        build_list (dictionary): All the builds and their exit code.

    Returns:
        List: Int. Exit code. 0 for success.
              str. Exit message.

    """

    # Init return vars
    ret_msg = []
    out_msg = []
    exit_code = 0
    # Iterate through dict
    for b_name, out_code in build_list.iteritems():
        # Check exit code
        if out_code != 0:
            # Set error message
            err_msg = b_name + " build failed"
            out_msg.append(err_msg)
            exit_code += 1
    # Make return message
    ret_msg.append(exit_code)
    ret_msg.append(out_msg)
    return ret_msg


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
    born_unix = time.mktime(date(2017, 06, 13).timetuple())
    # Prep directory location
    target_dir = os.path.dirname(str(target[0]))
    target_dir = env.Dir(target_dir)
    target_f = env.File(str(target[0]))
    # Make and open target file to write
    target_file = open(str(target_f), 'w')
    # Init folder build vars
    build_out_list = {"lnk_bld":1, "py_bld":0, "rb_bld":0}
    link_exist = False
    # Iterate through folder
    for fname in source:
        # Get file last mod date
        fdate = os.path.getmtime(fname.rstr())
        # File basename
        fbase_name = os.path.basename(fname.rstr())
        # Check LINK.txt files
        if os.path.basename(fname.rstr()) == "LINK.txt":
            link_exist = True
            chal_link = str(fname.get_contents())
            build_out_list["lnk_bld"] = check_link(chal_link, target_dir)
            if build_out_list["lnk_bld"] == 0:
                target_file.write(chal_link + "- 200" + "\n")
        # Only check files created after builder
        elif fdate > born_unix:
            # Check python files
            if fbase_name.endswith(".py"):
                # Run linter
                build_out_list["py_bld"] = build_python(fname)
                if build_out_list["py_bld"] == 0:
                    target_file.write(fname.rstr() + "- py success \n")
            # Check ruby files
            elif fbase_name.endswith(".rb"):
                # Run linter
                build_out_list["rb_bld"] = build_ruby(fname)
                if build_out_list["rb_bld"] == 0:
                    target_file.write(fname.rstr() + "- rb success \n")
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
    # Check builds
    else:
        build_success = check_builds(build_out_list)
    # Print out message
    for msg in build_success[1]:
        print msg
    # Return exit code
    return build_success[0]
