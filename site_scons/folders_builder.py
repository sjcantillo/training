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
            if line.strip() in target_dir:
                in_list = True
    # Return answer
    return in_list


def check_link(chal_link):
    """Fn to check LINK.txt files. Fn makes the request, gets the http status
       code and checks for a 200ok.

    Args:
        chal_link (string) : url to challenge.

    Returns:
        Bool: True. If 200ok.

    """

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
    flake_cmd.append(str(fname))
    pylint_cmd = ["flake8"]
    pylint_cmd.append(str(fname))
    # Call flake8 and Pylint on python file
    try:
        out_flake = subprocess.call(flake_cmd, shell=False)
        out_plint = subprocess.call(pylint_cmd, shell=False)
    # Handle Errors
    except OSError as oerr:
        print "OSError > ", oerr.errno, " - ", oerr.strerror
    # Sum absolute value of exit codes
    output = abs(out_flake) + abs(out_plint)
    # Return combined exit code
    return output


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
    born_unix = time.mktime(date(2017, 06, 9).timetuple())
    # Prep directory location
    target_dir = os.path.dirname(str(target[0]))
    target_dir = env.Dir(target_dir)
    target_f = env.File(str(target[0]))
    # Make and open target file to write
    target_file = open(str(target_f), 'w')
    # Init folder build vars
    link_build = 1
    py_build = 0
    link_exist = False
    # Iterate through folder
    for fname in source:
        # Check LINK.txt files
        if os.path.basename(fname.rstr()) == "LINK.txt":
            link_exist = True
            chal_link = str(fname.get_contents())
            # Check whitelist
            white_list = check_whitelist(str(target_dir))
            if not white_list:
                # Check LINK.txt for 200ok
                link_build = check_link(chal_link)
            else:
                # Append result for whitelist files
                link_build = 0
                target_file.write(chal_link + " - WHITELIST ITEM \n")
            if link_build == 0:
                target_file.write(chal_link + "- 200" + "\n")
        # Check .py files
        elif os.path.basename(fname.rstr()).endswith(".py"):
            # Only check files created after builder
            fdate = os.path.getmtime(fname.rstr())
            if fdate > born_unix:
                try:
                    # Run linters
                    py_build = build_python(fname)
                # Handle errors
                except OSError as oerr:
                    print "OSError > ", oerr.errno, " - ", oerr.strerror
                    return 1
            else:
                # Omit build for old files
                py_build = 0
    # Close file
    target_file.close()
    target_f = env.File(target_file)
    # Check LINK.txt exist
    if not link_exist:
        print target_file.name[:-10], " - LINK file does not exist - "
        return 1
    # Check builds - LINK.txt
    elif link_build != 0:
        print " - LINK.txt Build Failed - "
        return 1
    # Check builds - python
    elif py_build != 0:
        print " - Python Build Failed - "
        return 1
    # All checks passed
    return 0
