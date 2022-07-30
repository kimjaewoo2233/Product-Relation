package com.data.productdata.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Itinerary {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        private String description;

        @ElementCollection(fetch = FetchType.EAGER)
        @CollectionTable(
                name = "itinerary_site",
                joinColumns = @JoinColumn(name="itinerary_id"))
        @OrderColumn(name = "list_idx")
        @Column(name = "site")
        private List<String> sites;

        public Itinerary(String name,String description,List<String> sites){
            this.name = name;
            this.description = description;
            this.sites = sites != null ? sites : new ArrayList<>();
        }

        public void clearSites(){
            sites.clear();
        }






}
