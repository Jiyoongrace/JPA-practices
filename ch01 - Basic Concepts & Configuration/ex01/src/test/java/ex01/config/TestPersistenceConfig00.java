package ex01.config;

import ex01.domain01_05.Pet;
import ex01.repository.PetRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes={PersistenceConfig01.class})
class TestPersistenceConfig00 {
    @Autowired
    private TransactionManager tm;

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Autowired
    private PetRepository petRepository;

    @BeforeEach
    public void setUpBeforeEachTest() {
        log.info("[Before Testing] TransactionManager: " + tm);
        log.info("[Before Testing] EntityManagerFactory: " + emf);
    }

    @Test
    @Transactional
    void testGuestbookRepositorySave() {
        Pet pet = new Pet();
        pet.setId(2);

        petRepository.save(pet);
    }
}
