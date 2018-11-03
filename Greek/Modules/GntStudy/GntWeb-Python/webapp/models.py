# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models

# Create your models here.
class GntWord(models.Model):
    id = models.AutoField(primary_key=True)
    word = models.CharField(max_length=200)
    book_id = models.CharField(max_length=200)
    chapter = models.IntegerField(default=0)
    verse = models.IntegerField(default=0)
    sequence = models.IntegerField(default=0)
    pub_date = models.DateTimeField('date published')

class GntBook(models.Model):
    id = models.AutoField(primary_key=True)
    name = models.CharField(max_length=200)
