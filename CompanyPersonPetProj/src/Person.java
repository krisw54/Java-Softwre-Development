public class Person
{
    private String name;
    private Pet pet;
    private Company company;

    public Company getCompany()
    {
        return company;
    }

    public void setCompany(Company company)
    {
        this.company = company;
    }


    public Person(String name)
    {
        this.name = name;
        pet = null;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Pet getPet()
    {
        return pet;
    }

    public void setPet(Pet pet)
    {
        this.pet = pet;
    }
}