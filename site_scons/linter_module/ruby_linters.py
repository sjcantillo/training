# -*- coding: utf-8 -*-
"""Linter Handler

This module provides linters to check ruby files and coding standards.

"""

import command_handler


def rb_bld(fname):
    """Fn to run ruby linter. Fn runs ruby-lint on the given
       file fname.

    Args:
        fname (string): path to rb file.

    Returns:
        Int: lint_result. 0 if success.

    """

    # Init return var
    build_result = []
    # Set out msg
    out_msg = "rb lint "
    # Set command
    lint_cmd = ["ruby-lint"]
    out_lint = command_handler.run_cmd(lint_cmd, fname)
    # Prep result
    build_result.append(out_lint)
    build_result.append(out_msg)
    # Return exit code
    return build_result
