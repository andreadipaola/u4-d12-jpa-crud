package app;

import java.time.LocalDate;

import dao.EventoDao;
import entities.TipoEvento;

public class Main extends EventoDao {

	public static void main(String[] args) {
		boolean inserisciEvento = false;
		boolean eliminaEvento = false;
		boolean getEvento = false;
		boolean modificaEvento = false;

		if (inserisciEvento) {
			inserisciEvento("Discoteca", LocalDate.parse("2022-07-10"),
					"Venite a scatenarvi con noi tra musica ed ospiti speciali", TipoEvento.PUBBLICO, 300);
			inserisciEvento("Festino privato", LocalDate.parse("2023-11-20"),
					"Vi aspettiamo nella lostra location da favorla", TipoEvento.PRIVATO, 400);
			inserisciEvento("Festa di compleanno", LocalDate.parse("2023-11-07"),
					"Vi aspetto tutti per festeggiare il mio compleanno", TipoEvento.PUBBLICO, 100);
			inserisciEvento("Sfilata di moda", LocalDate.parse("2021-09-11"),
					"Sfilata di moda nuove collezioni Gucci, Prada, Louis Vuitton", TipoEvento.PRIVATO, 150);
		}

		if (eliminaEvento) {
			eliminaEventoByID(3);
		}

		if (getEvento) {
			getEventoById(2);
		}

		if (modificaEvento) {
			updateEventoById(1, "Discoteca con open bar", LocalDate.parse("2022-07-10"),
					"Godetevi una serata sotto le stelle con open bar incluso", TipoEvento.PUBBLICO, 600);
		}

	}

}
