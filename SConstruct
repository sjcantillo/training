# -*- coding: utf-8 -*-

import os
import file_search
import urllib2
import cookielib
import string
import itertools

# Guarantee scons version
EnsureSConsVersion(2, 3)

# Build default construction environment
env = Environment()

# Set external variables
env['ENV']['PATH'] = os.environ['PATH']
env['ENV']['HOME'] = os.environ['HOME']

# Set signature
env.Decider('MD5-timestamp')

# Dissable python warnings
env['ENV']['PYTHONWARNINGS'] = 'ignore'

# File change cache location
env.SConsignFile('build/decider')
#env.CacheDir('build/build_cache')

# Find all required sources
#cpp_sources = fileSearch.find_sources('cpp', 0)
#cs_sources = fileSearch.find_sources('cs', 0)
#java_sources = fileSearch.find_sources('java', 0)
#js_sources = fileSearch.find_sources('js', 0)
#py_sources = fileSearch.find_sources('py', 0)
#rb_sources = fileSearch.find_sources('rb', 0)
#sh_sources = fileSearch.find_sources('sh', 0)
others_sources = file_search.find_sources('txt', 1)

# Prep targets
others_targets = others_sources
others_targets = [ot.replace('challenges', 'build') for ot in others_targets]

# Builder function for OTHERS
def build_others(target, source, env):
    # Prep cookie
    cj = cookielib.CookieJar()
    opener = urllib2.build_opener(urllib2.HTTPCookieProcessor(cj))
    # Get urls in OTHERS
    other = File(source[0])
    other_cont = other.get_contents()
    cont_arr = string.split(other_cont, '\n')
    cont_arr = [x.strip() for x in cont_arr]
    # Prep directory location
    target_dir = str(target[0])[:-10]
    target_dir = Dir(target_dir)
    target_f = File(str(target[0]))
    # Make and open target file to write
    target_file = open(str(target_f), 'w')
    # Iterate through urls
    for url in cont_arr:
        stat_code = 0
        if(len(url) > 0):
            # Prepend protocol if missing
            if(not url.startswith("http")):
                url = 'http://' + url
            try:
                # Prep and add headers
                headers = {
                    'Accept': 'text/html,application/xhtml+xml,'
                    'application/xml;q=0.9,*/*;q=0.8',
                    'User-Agent': 'Mozilla/5.0 (Windows NT 5.1;rv:10.0.1)'
                    'Gecko/20100101 Firefox/10.0.1',}
                opener.addheaders = headers.items()
                # Make req and get HTTP status code
                stat_code = opener.open(url).getcode()
            # Handle errors
            except (urllib2.HTTPError, urllib2.URLError) as e:
                print url + " -- HTTP/URL ERROR --"
                return 1
            # Check for valid response
            if(stat_code != 200):
                # Exit build with error 1
                print url + " - " + str(stat_code) + "HTTP Status Code not 200"
                return 1
            else:
                # 200 ok
                print url + " - " + str(stat_code)
                # Append result to target file
                target_file.write(url + " - " + str(stat_code) + "\n")
    # Close file
    target_file.close()
    target_f = File(target_file)

# Builder - OTHERS
bothers_builder = Builder(action = build_others)
env.Append(BUILDERS = {'BOthers' : bothers_builder})
for sr, tg in itertools.izip(others_sources, others_targets):
    bothers_run = env.BOthers(target = tg, source = sr)
