# -*- coding: utf-8 -*-

import os
import file_search
import itertools
import others_builder
import gherkin_builder

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
gherkin_sources = file_search.find_sources('feature', 0)
others_sources = file_search.find_sources('txt', 1)

# Prep OTHERS targets
others_targets = others_sources
others_targets = [ot.replace('challenges', 'build') for ot in others_targets]
# Prep Gherkin targets
gherkin_targets = gherkin_sources
gherkin_targets = [gt.replace('challenges', 'build') for gt in gherkin_targets]

# Builder - OTHERS
bothers_builder = Builder(action = others_builder.build_others)
env.Append(BUILDERS = {'Bothers' : bothers_builder})
for sr, tg in itertools.izip(others_sources, others_targets):
    bothers_run = env.Bothers(target = tg, source = sr)
env.Alias('others', others_targets)

# Builder - Gherkin
bgherkin_builder = Builder(action = gherkin_builder.build_gherkin)
env.Append(BUILDERS = {'Bgherkin' : bgherkin_builder})
for sr, tg in itertools.izip(gherkin_sources, gherkin_targets):
    gherkin_run = env.Bgherkin(target = tg, source = sr)
env.Alias('gherkin', gherkin_targets)

# Enable explicit builds only
Default(None)
