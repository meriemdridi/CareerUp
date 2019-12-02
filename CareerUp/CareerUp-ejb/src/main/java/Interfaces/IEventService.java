package Interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.Event;

@Remote
public interface IEventService {

	public int ajouterEvent(Event event);
	public List<Event> getAllEvents();
	public void deleteEvent(int idEvent);
	public void updateEvent(Event event);
}
