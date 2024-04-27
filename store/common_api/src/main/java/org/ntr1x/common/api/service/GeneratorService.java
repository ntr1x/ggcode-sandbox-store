package org.ntr1x.common.api.service;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class GeneratorService {

    public UUID randomUUID() {
        return UUID.randomUUID();
    }

    public int randomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public String randomString(int size) {
        RandomStringGenerator randomStringGenerator =
                new RandomStringGenerator.Builder()
                        .withinRange('0', 'z')
                        .filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
                        .get();
        return randomStringGenerator.generate(size);
    }
}
