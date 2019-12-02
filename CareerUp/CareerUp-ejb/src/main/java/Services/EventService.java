package Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.*;
import Interfaces.IEventService;

@Stateless
@LocalBean
public class EventService implements IEventService{

	@PersistenceContext
	EntityManager em;

	@Override
	public int ajouterEvent(Event event) {
		em.persist(event);
		return event.getIdEvent();
	}

	@Override
	public List<Event> getAllEvents() {
		List<Event> event = em.createQuery("Select e from Event e", Event.class).getResultList();
		return event;
	}

	@Override
	public void deleteEvent(int idEvent) {
		Event o = em.find(Event.class, idEvent);
		em.remove(o);
	}

	@Override
	public void updateEvent(Event event) {
		Event us = em.find(Event.class, event.getIdEvent());
		us.setNameEvent(event.getNameEvent());
		us.setDescription(event.getDescription());
		us.setEventDate(event.getEventDate());
		us.setLieu(event.getLieu());
		us.setLogo(event.getLogo());
		us.setCompany(event.getCompany());
	}
}
