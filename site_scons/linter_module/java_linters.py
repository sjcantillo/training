# -*- coding: utf-8 -*-
"""Linter Handler

This module provides linters to check java files and coding standards.

"""

import command_handler


def java_bld(fname):
    """Fn to run java linter. Fn runs checkstyle on the given
       file fname.

    Args:
        fname (string): path to java file.

    Returns:
        Int: lint_result. 0 if success.

    """

    # Init return var
    build_result = []
    # Set out msg
    out_msg = "java lint - checkstyle "
    # Set command
    lint_cmd = ["java"]
    lint_cmd.append("-jar")
    lint_cmd.append("site_scons/linter_module/resources/"
                     "checkstyle-7.7-all.jar")
    lint_cmd.append("-c")
    lint_cmd.append("/sun_checks.xml")
    out_lint = command_handler.run_cmd(lint_cmd, fname)
    # Prep result
    build_result.append(out_lint)
    build_result.append(out_msg)
    # Return exit code
    return build_result
