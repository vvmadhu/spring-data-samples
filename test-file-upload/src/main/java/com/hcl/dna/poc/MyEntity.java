package com.hcl.dna.poc;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
@Entity(name = "fileupload")
public class MyEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "filename")
    private String filename;

    @Lob
    @Column(name = "filecontent")
    private byte[] fileContent;
}
