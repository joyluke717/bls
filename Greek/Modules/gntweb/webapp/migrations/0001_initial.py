# -*- coding: utf-8 -*-
# Generated by Django 1.11.15 on 2018-08-18 21:10
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='GntBook',
            fields=[
                ('id', models.AutoField(primary_key=True, serialize=False)),
                ('name', models.CharField(max_length=200)),
            ],
        ),
        migrations.CreateModel(
            name='GntWord',
            fields=[
                ('id', models.AutoField(primary_key=True, serialize=False)),
                ('word', models.CharField(max_length=200)),
                ('book_id', models.CharField(max_length=200)),
                ('chapter', models.IntegerField(default=0)),
                ('verse', models.IntegerField(default=0)),
                ('sequence', models.IntegerField(default=0)),
                ('pub_date', models.DateTimeField(verbose_name='date published')),
            ],
        ),
    ]
