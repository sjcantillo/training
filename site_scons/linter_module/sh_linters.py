# -*- coding: utf-8 -*-
"""Linter Handler

This module provides linters to check sh files and coding standards.

"""

import command_handler


def sh_bld(fname):
    """Fn to run bash linter. Fn runs shellcheck on the given
       file fname.

    Args:
        fname (string): path to js file.

    Returns:
        Int: lint_result. 0 if success.

    """

    # Init return var
    build_result = []
    # Set out msg
    out_msg = "sh lint - shellcheck "
    # Set command
    lint_cmd = ["shellcheck"]
    out_lint = command_handler.run_cmd(lint_cmd, fname)
    # Prep result
    build_result.append(out_lint)
    build_result.append(out_msg)
    # Return exit code
    return build_result
