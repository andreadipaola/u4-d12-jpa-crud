package dao;

import java.time.LocalDate;

import entities.Evento;
import entities.TipoEvento;
import utils.JpaUtil;

public class EventoDao extends JpaUtil {

	public static void inserisciEvento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMaxPartecipanti) {
		try {
			Evento e = new Evento();
			e.setTitolo(titolo);
			e.setDataEvento(dataEvento);
			e.setDescrizione(descrizione);
			e.setTipoEvento(tipoEvento);
			e.setNumeroMaxPartecipanti(numeroMaxPartecipanti);
			t.begin();
			em.persist(e);
			t.commit();

			System.out.println("Evento inserito correttamente");
		} catch (Exception e) {
			System.out.println("ERRORE durante l'inserimento dell'evento!!");
		}

	}

	public static void getEventoById(int id) {
		Evento e = em.find(Evento.class, id);
		if (e == null) {
			System.out.println("L'evento con l'id " + id + " non è stato trovato!");
			return;
		}
		System.out.println("Dati evento #" + id);
		System.out.printf(
				"Titolo: %s | Data evento: %s | Descrizione: %s | Tipo evento: %s | Massimo partecipanti: %d%n",
				e.getTitolo(), e.getDataEvento(), e.getDescrizione(), e.getTipoEvento(), e.getNumeroMaxPartecipanti());
	}

	public static void eliminaEventoByID(int id) {
		Evento e = em.find(Evento.class, id);
		if (e == null) {
			System.out.println("L'evento con l'id " + id + " non è stato trovato!");
			return;
		}
		t.begin();
		em.remove(e);
		System.out.println("Evento eliminato correttamente!");
		t.commit();
	}

	public static void persist(Object entity) {
		t.begin();
		em.persist(entity);
		t.commit();
	}

	public static Evento getEvento(int id) {

		Evento e = em.find(Evento.class, id);
		if (e == null) {
			System.out.println("L'evento con l'id " + id + " non è stato trovato!");
			return null;
		}

		return e;
	}

	public static void updateEventoById(int id, String titolo, LocalDate dataEvento, String descrizione,
			TipoEvento tipoEvento, int numeroMaxPartecipanti) {

		Evento ev = getEvento(id);
		if (ev == null) {
			return;
		}

		try {
			ev.setTitolo(titolo);
			ev.setDataEvento(dataEvento);
			ev.setDescrizione(descrizione);
			ev.setTipoEvento(tipoEvento);
			ev.setTipoEvento(tipoEvento);

			persist(ev);

			System.out.println("L'evento con l'id " + id + " è stato aggiornato!");

		} catch (Exception e) {
			System.out.println("ERRORE nella modifica dell'evento!");
		}
	}
}