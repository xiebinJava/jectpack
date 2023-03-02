package com.fs.module.home.country.data

data class CountryModel(
    val list: List<CountrySit>,
)

data class CountrySit(
    val areaList: List<Area>,
    val areaName: String,
    val linePosition: Int,
)

data class Area(
    val area: String,
    val citys: List<City>,
    val countries_chinese_name: String,
    val countries_id: Int,
    val countries_name: String,
    val currency: String,
    val id: Int,
    val iso_code: String,
    val language: String,
    val symbol: String,
)

data class City(
    val city: String,
    val city_code: String,
)