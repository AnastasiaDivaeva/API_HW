package dto;

import java.util.Set;

public class PetDTO {
    private int id;
    private CategoryDTO category;
    private String name;
    private Set<String> photoUrls;
    private Set<TagDTO> tags;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(Set<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public Set<TagDTO> getTags() {
        return tags;
    }

    public void setTags(Set<TagDTO> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public static PetDTO createPet(int petId, String petName, String petStatus, Set<TagDTO> tags,
                                   Set<String> photoUrls, CategoryDTO category) {
        PetDTO petToCreate = new PetDTO();
        petToCreate.setId(petId);
        petToCreate.setCategory(category);
        petToCreate.setName(petName);
        petToCreate.setStatus(petStatus);
        petToCreate.setPhotoUrls(photoUrls);
        petToCreate.setTags(tags);
        return petToCreate;
    }
}
