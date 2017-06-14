# -*- coding: utf-8 -*-
"""Linter Handler

This module provides linters to check c files and coding standards.

"""

import command_handler


def clang_bld(fname):
    """Fn to run c linter. Fn runs splint on the given
       file fname.

    Args:
        fname (string): path to rb file.

    Returns:
        Int: lint_result. 0 if success.

    """


    # Init return var
    build_result = []
    # Set out msg
    out_msg = "c lint "
    # Set command
    lint_cmd = ["splint"]
    out_lint = command_handler.run_cmd(lint_cmd, fname)
    # Prep result
    build_result.append(out_lint)
    build_result.append(out_msg)
    # Return exit code
    return build_result
