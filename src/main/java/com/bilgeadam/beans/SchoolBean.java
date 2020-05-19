package com.bilgeadam.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.bilgeadam.dao.SchoolDAO;;

@ManagedBean (name = "schoolBean")
public class SchoolBean {

	
	
	// Method To Fetch The Existing School List From The Database
	public List<SchoolBean> schoolListFromDb() {
		return SchoolDAO.getAllSchoolDetails();		
	}
	@PostConstruct
	public List<SchoolBean> AllSchoolListFromDb() {
		return SchoolDAO.getAllSchools();		
	}

	// Method To Add New School To The Database
	public String addNewSchool(SchoolBean schoolBean) {
		return SchoolDAO.createNewSchool(schoolBean.getName());		
	}

	// Method To Delete The School Details From The Database
	public String deleteSchoolById(int schoolId) {		
		return SchoolDAO.deleteSchoolDetails(schoolId);		
	}

	// Method To Navigate User To The Edit Details Page And Passing Selecting School Id Variable As A Hidden Value
	public String editSchoolDetailsById() {
		editSchoolId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedSchoolId");		
		name = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedSchoolName");
		return "schoolEdit.xhtml";
	}

	// Method To Update The School Details In The Database
	public String updateSchoolDetails(SchoolBean schoolBean) {
		return SchoolDAO.updateSchoolDetails(Integer.parseInt(schoolBean.getEditSchoolId()), schoolBean.getName());		
	}
	
	private int id;
	private String name;	
	private String editSchoolId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEditSchoolId() {
		return editSchoolId;
	}

	public void setEditSchoolId(String editSchoolId) {
		this.editSchoolId = editSchoolId;
	}
}