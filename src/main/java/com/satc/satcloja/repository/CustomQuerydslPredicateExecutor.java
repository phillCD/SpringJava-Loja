package com.satc.satcloja.repository;

import com.querydsl.core.types.Predicate;
import com.satc.satcloja.model.Produto;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;


public interface CustomQuerydslPredicateExecutor<T> extends QuerydslPredicateExecutor<Produto> {


    @Override
    List<Produto> findAll(Predicate predicate);
}
