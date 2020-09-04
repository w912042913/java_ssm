package com.neusoft.dao;

import com.neusoft.domain.Emp;

import java.util.List;

public interface IEmpDao
{
    List<Emp> findAll();

    Emp findBySal(Integer sal);

    int savaEmp(Emp emp);
}
