# -*- coding: utf-8 -*-
"""HTTP Handler

This module creates an HTTP session and provides methods to work with it.

"""

import cookielib
import requests  # pylint: disable=F0401
from requests.adapters import HTTPAdapter  # pylint: disable=F0401


def get_code(chal_link):
    """Fn to make requests. Fn makes a request to the given URL and gets the
       HTTP status code.

    Args:
        chal_link (string): given URL to get HTTP status code from.

    Returns:
        Int: stat_code. HTTP status code.
             1 if error.

    """

    # Prep cookie
    cookiej = cookielib.CookieJar()
    # Prep requests Session
    rsession = requests.Session()
    rsession.mount('http://', HTTPAdapter(max_retries=3))
    rsession.mount('https://', HTTPAdapter(max_retries=3))
    # Prep headers
    headers = {
        'Accept': 'text/html,application/xhtml+xml,'
                  'application/xml;q=0.9,*/*;q=0.8',
        'User-Agent': 'Mozilla/5.0 (Windows NT 5.1;rv:10.0.1)'
                      'Gecko/20100101 Firefox/10.0.1',
        'Accept-Encoding': 'gzip, deflate'
    }
    # Add headers / Cookie
    rsession.headers.update(headers)
    rsession.cookies.update(cookiej)
    stat_code = 0
    link_len = len(chal_link)
    if link_len > 0:
        try:
            # Make req and get HTTP status code
            stat_code = rsession.get(chal_link, timeout=10).status_code
        # Handle errors
        except (requests.ConnectionError, requests.Timeout) as excpt:
            print chal_link + " -- Connection/Timeout ERROR --"
            print excpt
            stat_code = 1
        except ValueError:
            print "-- VALUEERROR-- blank link" + chal_link
            stat_code = 1
    # Return stat code
    return stat_code
