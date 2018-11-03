# -*- coding: utf-8 -*-
from __future__ import unicode_literals

# Register your models here.
from django.contrib import admin

from .models import GntBook, GntWord

admin.site.register(GntBook)

admin.site.register(GntWord)
