# -*- coding: utf-8 -*-
"""Builder for all folders

This module provides the builder function for all folders.

"""

import request_session
import os.path


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
            # Get HTTP Status code
            stat_code = request_session.get_code(chal_link)
            # Check for valid response
            if stat_code != 200:
                # Exit build with error 1
                print chal_link + " - " + str(stat_code) + " Status Code not 200"
                #return 1
            else:
                # 200 ok
                print chal_link + " - " + str(stat_code)
                # Append result to target file
                target_file.write(chal_link + " - " + str(stat_code) + "\n")
    # Close file
    target_file.close()
    target_f = env.File(target_file)
    if not link_exist:
        print target_file.name[:-10], " - LINK file does not exist -- "
        #return 1
    return 0