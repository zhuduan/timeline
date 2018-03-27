package com.timeline.service;

import com.timeline.model.PO.Subject;

import java.util.List;

public interface SearchService {
  /***
   *
   * 后续用solr或者elasticsearch
   * */
  List<Subject> searchSubjects(String key, Integer pageNum);
}
