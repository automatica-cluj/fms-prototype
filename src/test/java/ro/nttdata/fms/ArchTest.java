package ro.nttdata.fms;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("ro.nttdata.fms");

        noClasses()
            .that()
            .resideInAnyPackage("ro.nttdata.fms.service..")
            .or()
            .resideInAnyPackage("ro.nttdata.fms.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..ro.nttdata.fms.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
