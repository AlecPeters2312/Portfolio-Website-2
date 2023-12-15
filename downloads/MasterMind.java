package mastermind;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MasterMind
{
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m";
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m";
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m";
    public static final String BLACK_BOLD = "\033[1;30m";
    public static final String WHITE_BOLD = "\033[1;37m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    // hierboven zie je de kleurcodes die je kunt toepassen bij tekst om het een
    // kleur te geven.

    public static void main(String[] args) throws InterruptedException
    {

	Scanner invoer = new Scanner(System.in);

	System.out.println(BLUE_BOLD_BRIGHT + "Hier komt wat uitleg");
	TimeUnit.MILLISECONDS.sleep(600);
	System.out.println(BLACK_BOLD + "\nZwart" + BLUE_BOLD_BRIGHT + " = goede plek");
	TimeUnit.MILLISECONDS.sleep(600);
	System.out.println(WHITE_BOLD + "Wit" + BLUE_BOLD_BRIGHT + " = erin, verkeerde plek");
	TimeUnit.MILLISECONDS.sleep(600);
	System.out.println("Niks = nummer er niet in");
	TimeUnit.MILLISECONDS.sleep(600);
	System.out.println("Geef een getal van 1 tot 6");
	TimeUnit.MILLISECONDS.sleep(600);
	System.out.println("Je krijgt 10 beurten");
	TimeUnit.MILLISECONDS.sleep(600);
	System.out.println(GREEN_BOLD_BRIGHT + "Veel plezier en succes met raden!" + ANSI_RESET);
	TimeUnit.MILLISECONDS.sleep(600);
	// hierboven geef ik wat uitleg over het spel met 600 miliseconden ertussen
	// voordat de volgende regel afgedrukt wordt.

	int gok1, gok2, gok3, gok4, zwart = 0, wit = 0, beurt = 0;
	boolean winnaar = false;

	Random rand = new Random();
	int code1 = rand.nextInt(6) + 1;
	int code2 = rand.nextInt(6) + 1;
	int code3 = rand.nextInt(6) + 1;
	int code4 = rand.nextInt(6) + 1;
	System.out.println("" + code1 + code2 + code3 + code4);
	// hierboven heb ik gezorgd dat de integers code 1 tot 4 een random getal tot de
	// 6 hebben en beginnen bij 1.

	while (beurt < 10 && !winnaar)
	{
	    System.out.println(BLACK_BOLD_BRIGHT + "\n\nGeef je eerste gok" + ANSI_CYAN);
	    gok1 = invoer.nextInt();
	    System.out.println(ANSI_RESET + BLACK_BOLD_BRIGHT + "Geef je tweede gok" + ANSI_CYAN);
	    gok2 = invoer.nextInt();
	    System.out.println(ANSI_RESET + BLACK_BOLD_BRIGHT + "Geef je derde gok" + ANSI_CYAN);
	    gok3 = invoer.nextInt();
	    System.out.println(ANSI_RESET + BLACK_BOLD_BRIGHT + "Geef je vierde gok" + ANSI_CYAN);
	    gok4 = invoer.nextInt();
	    beurt++;
	    // hierboven geef ik aan dat je 4 gokken (cijfers van 1 tot 6) in moet voeren en
	    // elke keer dat je dat doet wordt er 1 opgetelt bij je beurten.

	    if (gok1 == code1)
	    {
		zwart++;
	    }
	    else if (gok1 == code2 || gok1 == code3 || gok1 == code4)
	    {
		wit++;
	    }

	    if (gok2 == code2)
	    {
		zwart++;
	    }
	    else if (gok2 == code1 || gok2 == code3 || gok2 == code4)
	    {
		wit++;
	    }

	    if (gok3 == code3)
	    {
		zwart++;
	    }
	    else if (gok3 == code1 || gok3 == code2 || gok3 == code4)
	    {
		wit++;
	    }

	    if (gok4 == code4)
	    {
		zwart++;
	    }
	    else if (gok4 == code1 || gok4 == code2 || gok4 == code3)
	    {
		wit++;
	    }
	    if (zwart == 4)
	    {
		System.out.println(ANSI_YELLOW + "Je hebt gewonnen!!" + ANSI_RESET);
		winnaar = true;
		// hier wordt gecheckt of je 4 keer een zwarte, dus een goede heb gehaald en als
		// dat zo is dan wordt er uitgeprint dat je gewonnen hebt.
	    }
	    if (gok1 == code1 || gok2 == code2 || gok3 == code3 || gok4 == code4)
	    {
		wit = 0;
	    }
	    if (zwart < 4)
	    {
		System.out.println(ANSI_RESET + BLACK_BOLD_BRIGHT + "Aantal " + BLACK_BOLD + "zwarten: " + WHITE_BOLD_BRIGHT + zwart);
		System.out.println(ANSI_RESET + BLACK_BOLD_BRIGHT + "Aantal " + WHITE_BOLD + "witte: " + WHITE_BOLD_BRIGHT + wit);
		System.out.println(ANSI_RESET + BLACK_BOLD_BRIGHT + "Je zit op je " + WHITE_BOLD_BRIGHT + beurt + "e" + ANSI_RESET + " beurt");
		wit = 0;
		zwart = 0;
	    }
	    // hier geeft hij na elke beurt aan hoeveel zwarten en hoeveel witte je goed
	    // hebt geraden.

	    if (beurt == 10)
	    {
		System.out.println(RED_BOLD_BRIGHT + "\nHelaas je beurten zijn op");
		// hier wordt gecheckt of je 10 beurten heb gebruikt en als dat zo is dan geeft
		// hij aan dat je beurten op zijn en dan kun je niet meer verder spelen.
	    }

	}

    }
}