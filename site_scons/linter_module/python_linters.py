# -*- coding: utf-8 -*-
"""Linter Handler

This module provides linters to check python files and coding standards.

"""

import command_handler


def py_bld(fname):
    """Fn to run python linter. Fn runs flake8 and pylint on the given
       file fname.

    Args:
        fname (string): path to py file.

    Returns:
        Int: lint_result. 0 if success.

    """


    # Init return var
    build_result = []
    # Set out msg
    out_msg = "py lint "
    # Set command
    lint_cmd = ["pylint"]
    flake_cmd = ["flake8"]
    out_lint = command_handler.run_cmd(lint_cmd, fname)
    out_flake = command_handler.run_cmd(flake_cmd, fname)
    # Calc combined exit code
    py_build = abs(out_lint) + abs(out_flake)
    # Prep result
    build_result.append(py_build)
    build_result.append(out_msg)
    # Return exit code
    return build_result