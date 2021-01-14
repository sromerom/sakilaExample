package com.liceu.sromerom.sakilaExample.repos;

import com.liceu.sromerom.sakilaExample.entities.OverdueDVD;

import java.util.List;

public interface OverdueDVDRepo {
    List<OverdueDVD> findAll();
}
