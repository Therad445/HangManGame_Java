package backend.academy.hangman;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Getter
@Log4j2
public class Difficulty {
    private int attemptsLeft;

    @Getter
    private enum DifficultyParams {
        EASY(6), MEDIUM(4), HARD(2);
        private final int maxAttempts;

        DifficultyParams(int attempts) {
            this.maxAttempts = attempts;
        }

    }

    public void setDifficulty(String level) {
        String upperLevel = level.toUpperCase();
        switch (upperLevel) {
            case "":
            case "EASY":
                this.attemptsLeft = DifficultyParams.EASY.maxAttempts;
                log.info("Выбрана легкая сложность");
            case "MEDIUM":
                this.attemptsLeft = DifficultyParams.MEDIUM.maxAttempts;
                log.info("Выбрана средняя сложность");
            case "HARD":
                this.attemptsLeft = DifficultyParams.HARD.maxAttempts;
                log.info("Выбрана тяжелая сложность");
            default:
                throw new IllegalArgumentException("Invalid difficulty level: " + level);
        }
    }
}
