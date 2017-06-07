# -*- coding: utf-8 -*-
"""Builder for all folders

This module provides the builder function for all folders.

"""

import os.path
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
    # Get whitelist into list
    with open(white_file) as whitef:
        dir_whitelist = [d.strip('\n') for d in whitef.readlines()]
    in_list = False
    # Iterate through whitelist
    for itm in dir_whitelist:
        # Check for hit
        if itm in str(target_dir):
            in_list = True
    # Return answer
    return in_list


def build_folders(target, source, env):
    """Fn to build folders. Fn makes a request to all URLs in the text file
       and gets the HTTP status code. It creates a new target file with all
       URLs and their respective HTTP status code. All status code 200 ok are
       valid.

    Args:
        target    (list): Path to target file.
        source    (list): Path to source file (OTHERS.txt containing URLs).
        env  (SCons.Env): SCons environment from SConstruct.

    Returns:
        Int: 1. For build error.
             0. For successfull build.

    """

    # Prep directory location
    target_dir = os.path.dirname(str(target[0]))
    target_dir = env.Dir(target_dir)
    target_f = env.File(str(target[0]))
    # Make and open target file to write
    target_file = open(str(target_f), 'w')
    # Check for LINK.txt
    link_exist = False
    for fname in source:
        if os.path.basename(fname.rstr()) == "LINK.txt":
            link_exist = True
            chal_link = str(fname.get_contents())
            # Check whitelist
            white_list = check_whitelist(target_dir)
            if not white_list:
                # Get HTTP Status code
                stat_code = request_session.get_code(chal_link)
                # Check for valid response
                if stat_code != 200:
                    # Exit build with error 1
                    print chal_link + " Stat Code not 200 - " + str(stat_code)
                    return 1
                else:
                    # 200 ok
                    print str(stat_code)
                    # Append result to target file
                    target_file.write(chal_link + "-" + str(stat_code) + "\n")
            else:
                # Append result for whitelist files
                target_file.write(chal_link + " - WHITELIST ITEM \n")
    # Close file
    target_file.close()
    target_f = env.File(target_file)
    if not link_exist:
        print target_file.name[:-10], " - LINK file does not exist -- "
        return 1
    return 0
