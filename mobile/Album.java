package mobile;

public class Album {
	Musica music1 = new Musica("Raul Seixas","Eu nasci a 10 mil anos atras",4.56);
	Musica music2 = new Musica("Legiao Urbana","Tempo Perdido",3.54);
	Musica music3 = new Musica("Geraldo Vandre","Requiem para Matraga",2.17);
	
	Album(){
		music1.setProxima(music2);
		music2.setProxima(music3);
		music3.setProxima(music1);
		
		music1.setAnterior(music3);
		music2.setAnterior(music1);
		music3.setAnterior(music2);
	}
	
}
