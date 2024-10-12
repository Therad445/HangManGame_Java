package backend.academy;

import backend.academy.hangman.Category;
import backend.academy.hangman.Difficulty;
import backend.academy.hangman.HangmanGame;
import backend.academy.hangman.Words;
import java.util.Scanner;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

@UtilityClass
@Log4j2
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Category categories = new Category(HangmanGame.HANGMAN_WORDS());
        log.info("Выберите категорию:{}", categories.categoriesArray());
        String category = scanner.nextLine().toLowerCase();
        categories.usingCategory(category);
        log.info((categories.usingCategory()));

        log.info("Выберете сложность: [легко, средне, сложно]");
        Difficulty difficulties = new Difficulty();
        difficulties.setDifficulty(scanner.nextLine().toLowerCase());

        Words words = new Words(HangmanGame.HANGMAN_WORDS().get(category));
        words.usingWord(words.randomWord());
        log.info("Слово выбрано.");

        HangmanGame game = new HangmanGame(categories.usingCategory(), words.usingWord(), difficulties.attemptsLeft());
        log.info("Игра началась:");
        while (!game.gameOver()) {
            game.displayInfo();
            log.info("Ввведите букву:");
            char symbol = scanner.nextLine().charAt(0);
            game.inputChar(symbol);
        }
        scanner.close();
    }
}

