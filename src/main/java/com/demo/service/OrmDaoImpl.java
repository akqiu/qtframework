package com.demo.service;

/**
 * Created by qiutian on 16-9-28.
 */
public class OrmDaoImpl {
/*
    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public List<AreaDto> getAreaDtos() {
        String sql = "select * from t_area ";
        return (List<AreaDto>) template.query(sql, new BeanPropertyRowMapper(AreaDto.class));
    }

    public List<AreaDto> getAreaDtos1() {
        String sql = "select * from t_area ";
        return (List<AreaDto>) template.query(sql, new AreaRowMapper());
    }

    public Map<String, Object> getBuilds() {
        String sql = "select buildid,buildname from t_building ";
        List<BuildingDto> list = this.template.query(sql, new BeanPropertyRowMapper(BuildingDto.class));
        Map<String, Object> map = new HashMap<String, Object>();
        for (BuildingDto build : list) {
            map.put(String.valueOf(build.getBuildid()), build.getBuildname());
        }
        return map;
    }

    public Map<String, Object> getFloors(String build) {
        String sql = "select floorid ,floorname from t_floor where build_id=?";
        List<FloorDto> list = this.template.query(sql, new Object[] { build }, new BeanPropertyRowMapper(FloorDto.class));
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        for (FloorDto floorDto : list) {
            System.out.println(floorDto.getFloorid());
            map.put(String.valueOf(floorDto.getFloorid()), floorDto.getFloorname());
        }
        return map;
    }

    public Map<String, Object> getAreas(String build, String floor) {
        String sql = "select areaid ,area_name from t_area where build_id=? and floor_id=?";
        List<AreaDto> list = this.template.query(sql, new Object[] { build, floor }, new BeanPropertyRowMapper(AreaDto.class));
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        for (AreaDto areaDto : list) {
            System.out.println(areaDto.getAreaid());
            map.put(String.valueOf(areaDto.getAreaid()), areaDto.getArea_name());
        }
        return map;
    }

    public List<StoreDto> getStoreDtos(int buildid, int floorid, int areaid) {
        String sql = "select * from t_store where build_id=? and floor_id=? and area_id=?";
        return (List<StoreDto>) template.query(sql, new Object[] { buildid, floorid, areaid }, new BeanPropertyRowMapper(
                StoreDto.class));
    }

    public List<BuildingDto> getBuildingDto() {
        String sql = "select * from t_building ";
        return (List<BuildingDto>) template.query(sql, new BeanPropertyRowMapper(BuildingDto.class));
    }

    public List<FloorDto> getFloorDtos(int buildid) {
        String sql = "select * from t_floor where build_id=? ";
        return (List<FloorDto>) template.query(sql, new Object[] { buildid }, new BeanPropertyRowMapper(FloorDto.class));
    }

    public List<AreaDto> getAreaDto(int buildid, int floorid) {
        String sql = "select * from t_area where build_id=? and floor_id=?";
        return (List<AreaDto>) template.query(sql, new Object[] { buildid, floorid }, new BeanPropertyRowMapper(AreaDto.class));
    }

    public AreaDto getAreaDto(int id) {
        String sql = "select * from t_area where areaid=?";
        return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper(AreaDto.class));
    }

    public BuildingDto getBuildingDto(int buildId) {
        String sql = "select * from t_building where buildid=?";
        return template.queryForObject(sql, new Object[] { buildId }, new BeanPropertyRowMapper(BuildingDto.class));
    }

    public FloorDto getFloorDto(int floorId) {
        String sql = "select * from t_floor where floorid=?";
        return template.queryForObject(sql, new Object[] { floorId }, new BeanPropertyRowMapper(FloorDto.class));
    }

    public List<StoreDto> getAllStores() {
        String sql = "select * from t_store ";
        return (List<StoreDto>) template.query(sql, new BeanPropertyRowMapper(StoreDto.class));
    }

    public String storeName(int storeId) {
        String sql = "select storename from t_store where id=?";
        return template.queryForObject(sql, new Object[] { storeId }, String.class);
    }

    public StoreDto getStoreById(int storeInt) {
        String sql = "select * from t_store where id=?";
        return template.queryForObject(sql, new Object[] { storeInt }, new BeanPropertyRowMapper(StoreDto.class));
    }

    public int getCountStore() {
        String sql = "select count(id) from t_store";
        return this.template.queryForInt(sql);
    }

    public void saveBuild(BuildingDto buildingDto) {
    }

    public void deleteBuildById(int buildid) {
        String sql = "delete from t_store where id=?";
        this.template.update(sql, buildid);
    }

    public void updateBuildById(BuildingDto buildingDto) {

    }
*/
}
