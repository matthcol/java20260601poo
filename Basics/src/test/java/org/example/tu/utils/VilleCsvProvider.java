package org.example.tu.utils;

import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

class VilleCsvProvider {
    static Stream<Arguments> lineProvider(){
        String[] line01 = {
                "0","01001","L'Abergement-Clémenciat","Abergement-Clémenciat","à Abergement-Clémenciat",
                "de l'Abergement-Clémenciat","l-abergement-clemenciat",
                "L'ABERGEMENT-CLÉMENCIAT","COM","commune","84","Auvergne-Rhône-Alpes",
                "01","Ain","0108","Châtillon-sur-Chalaronne","200069193","CC de la Dombes","10",
                "Lyon","01400","01400","08405","01053","01000","","0.0","HORS UNITE URBAINE",
                "H","832","1565","16","53.0","242","206.0","272.0","46.151","4.921","46.153",
                "4.926","6","Rural à habitat dispersé","0.0","communes non pôle","",
                "https://fr.wikipedia.org/wiki/fr:L'Abergement-Clémenciat",
                "https://villedereve.fr/ville/01001-l-abergement-clemenciat"
        };
        String[] line44 = {
                "16293","44109","Nantes","Nantes","à Nantes",
                "de Nantes","nantes",
                "NANTES","COM","commune","52","Pays de la Loire",
                "44","Loire-Atlantique","4496","Nantes","244400404","Nantes Métropole","17",
                "Nantes","44200",
                "44011, 44063, 44065, 44094, 44272, 44331, 44032, 44053, 44335, 44958, 44002, 44040, 44084, 44313, 44316, 44921, 44042, 44047, 44079, 44109, 44315, 44337, 44300, 44017, 44019, 44067, 44273, 44100, 44059, 44106, 44963, 44005, 44021, 44024, 44262, 44301, 44949, 44000, 44061, 44083, 44087, 44306, 44329, 44014, 44016, 44071, 44082, 44101, 44261, 44304, 44312, 44933, 44018, 44081, 44201, 44932, 44004, 44012, 44078, 44086, 44263, 44324, 44088, 44184, 44185, 44276, 44319, 44333, 44010, 44188, 44326, 44036, 44066, 44074, 44076, 44090, 44311, 44372, 44926, 44046, 44103, 44176, 44314, 44321, 44945, 44200, 44006, 44009, 44077, 44327, 44008, 44013, 44104, 44179, 44274, 44305, 44322, 44325, 44096, 44373, 44265, 44302, 44323, 44328, 44015, 44020, 44034, 44092, 44202, 44035, 44041, 44072, 44102, 44205, 44303, 44332, 44339, 44964, 44023, 44336, 44966, 44107, 44203, 44338, 44003, 44022, 44062, 44334, 44923, 44939, 44001, 44033, 44038, 44070, 44186, 44187, 44275, 44308, 44806, 44093, 44097, 44900, 44922, 44075, 44085, 44105, 44277, 44307, 44007, 44204",
                "05216","44109","44701","Nantes","7.0","UNITE URBAINE","C","323204","6577","66","4914.0","18","2.0",
                "52.0","47.218","-1.554","47.232","-1.548","1","Grands centres urbains",
                "4.0","centres majeurs d'équipements et de services","Nantais(e)",
                "https://fr.wikipedia.org/wiki/fr:Nantes",
                "https://villedereve.fr/ville/44109-nantes"
        };
        String[] line2B = {
                "10536","2A004","Ajaccio","Ajaccio","à Ajaccio",
                "d'Ajaccio","ajaccio",
                "AJACCIO","COM","commune","94","Corse",
                "2A","Corse-du-Sud","2A98","Ajaccio","242010056","CA du Pays Ajaccien","27",
                "Corse","20000",
                "20175, 20182, 20184, 20700, 20502, 20306, 20303, 20192, 20501, 20178, 20503, 20176, 20704, 20162, 20181, 20186, 20179, 20188, 20180, 20702, 20191, 20185, 20701, 20193, 20174, 20183, 20177, 20195, 20189, 20302, 20504, 20000, 20090, 20167",
                "09401","2A004","2A501","Ajaccio","5.0","UNITE URBAINE","C","73822","8314","83","888.0","136","0.0",
                "790.0","41.919","8.739","41.935","8.701","2","Centres urbains intermédiaires",
                "4.0","centres majeurs d'équipements et de services","Ajacciens",
                "https://fr.wikipedia.org/wiki/fr:Ajaccio",
                "https://villedereve.fr/ville/2A004-ajaccio"
        };
        return Stream.of(
                // line, expectedNom, expectedDepartement, expectedCodeInsee, expectedCodePostal,
                // expectedPopulation, expectedSuperficie, expectedAltitudeMaximale
                Arguments.of(
                        Named.of("Ville du 01", line01),
                        "L'Abergement-Clémenciat", "01", "01001", "01400", 832, 16, 272
                ),
                Arguments.of(
                        Named.of("Ville du 44", line44),
                        "Nantes", "44", "44109", "44200", 323_204, 66, 52
                ),
                Arguments.of(
                        Named.of("Ville du 2A (Corse)", line2B),
                        "Ajaccio", "2A", "2A004", "20000", 73_822, 83, 790
                )
        );
    }
}
