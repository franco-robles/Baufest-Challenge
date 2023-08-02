package com.baufest.ingreso.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RepeatedCharactersTest {

	private RepeatedCharacters repeatedCharacters = new RepeatedCharacters();

	@Test
	public void isValidSimple() {
		String input = "a3o1oa3";
		assertTrue(this.repeatedCharacters.isValid(input));
		assertTrue(this.repeatedCharacters.isValid("aa3311oo"));
	}
	//comprueba que se cumpla lo siguiente:
	//2- Todos los caracteres aparecen la misma cantidad de veces, a excepcion de 1, que aparece un vez mas o una vez menos.
	@Test
	public void DosCharAparecenUnaVezMenos() {
		String input = "a3o1oa32"; //el 1 y 2 aparecen una vez menos, pero solo se permite un caracter con esta excepcion
		assertFalse(this.repeatedCharacters.isValid(input));
		assertFalse(this.repeatedCharacters.isValid("aa3311oo2222999"));  //el 2 y 9 aparecen una vez mas, pero solo se permite un caracter con esta excepcion
	}

	@Test
	public void isValidWithSpaces() {
		String input = " ellemmeennttaall  mmaattssssnn";
		assertTrue(this.repeatedCharacters.isValid(input));
		assertFalse(this.repeatedCharacters.isValid(" eelleemmeennttaall  mmii  qquueerriiddoo  wwaattssoonn"));
	}

	@Test
	public void isValidWithExtraChar() {
		String input = "aabbccc";
		assertTrue(this.repeatedCharacters.isValid(input));
		assertFalse(this.repeatedCharacters.isValid("aaabbc"));
	}
}
