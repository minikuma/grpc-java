package me.minikuma.v2.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleRepository {
    String getString();
}
