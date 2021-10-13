package dto.models;

import javax.persistence.*;

    @Entity
    public class Giraffe {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;

        public Giraffe() {
            String s = new String();
        }

        public Giraffe(int id, String first_name) {
            this.id = id;
            this.name = first_name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String first_name) {
            this.name = first_name;
        }
    }
