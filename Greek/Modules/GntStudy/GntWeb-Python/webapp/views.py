# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.http import HttpResponse


def index(request):
    return HttpResponse("Hello, world. You're at the polls index.")

def allbook(request):
    return HttpResponse("You're looking at question.")

def getOneBook(request, book_id):
    response = "You're looking at the results of book id %s."
    return HttpResponse(response % id)
