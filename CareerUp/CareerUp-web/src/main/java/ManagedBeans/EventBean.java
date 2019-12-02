package ManagedBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Services.EventService;
import javax.servlet.http.Part;
import Entities.*;

@ManagedBean(name = "eventBean")
@SessionScoped
public class EventBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer userIdUpdated;
	private String nameEvent;
	private String description;
	private Date eventDate;
	private String lieu;
	private String logo;
	private Part part;
	private List<Event> events;

	public List<Event> getEvents() {
		events = eventService.getAllEvents();
		return events;
	}
	
	
	public Part getPart() {
		return part;
	}


	public void setPart(Part part) {
		this.part = part;
	}


	public Integer getUserIdUpdated() {
		return userIdUpdated;
	}
	public void setUserIdUpdated(Integer userIdUpdated) {
		this.userIdUpdated = userIdUpdated;
	}
	public String getNameEvent() {
		return nameEvent;
	}
	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public EventBean() {
		super();
	}
	public EventBean(String nameEvent, String description, Date eventDate, String lieu, String logo) {
		super();
		this.nameEvent = nameEvent;
		this.description = description;
		this.eventDate = eventDate;
		this.lieu = lieu;
		this.logo = logo;
	}
	public EventBean(Integer userIdUpdated, String nameEvent, String description, Date eventDate, String lieu,
			String logo) {
		super();
		this.userIdUpdated = userIdUpdated;
		this.nameEvent = nameEvent;
		this.description = description;
		this.eventDate = eventDate;
		this.lieu = lieu;
		this.logo = logo;
	}
	
	@EJB
	EventService eventService;

	
	public String Upload() throws IOException {
		part.write("D:\\Me\\work\\Education\\SOA\\workspace_webservice\\CareerUp\\CareerUp-ejb\\src\\main\\java\\Pictures"+getFileName(part));
		
		return "result";
	}
	private static String getFileName(Part part){
		
		for(String cd: part.getHeader("content-disposition").split(";")){
			
			if(cd.trim().startsWith("filename")){
				
				String filename= cd.substring(cd.indexOf('=')+1).trim().replace("\"", "");
				return filename.substring(filename.lastIndexOf('/')+1).substring(filename.lastIndexOf('\\')+1);
			}
			
		}
		return null;
		
	}
	public void addEvent() throws IOException
	{
		part.write("D:\\Me\\work\\Education\\SOA\\workspace_webservice\\CareerUp\\CareerUp-ejb\\src\\main\\java\\Pictures"+getFileName(part));
		this.logo=	getFileName(this.part);
		eventService.ajouterEvent(new Event(nameEvent, eventDate, description, lieu, logo));
	}

}
