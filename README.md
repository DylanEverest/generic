## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


## Key Features

- `Form Generation Library:` A generic library that allows developers to create forms for any object in their Java applications. This library streamlines the process of generating user interfaces and data entry forms.

- `Sorting Library`: A versatile sorting library that can be applied to any object type. It provides various sorting algorithms to efficiently organize data collections.


## Generate FORM

Your object should extends generic.Generic



Here's an example :

    import java.util.Date;

    import generic.Generic;

    public class Person extends Generic<Person>{
    
    String name ;
    int age ;
    Date dateDeNaissance;
    boolean isDispo =false ;
    Physic physic ;


    public Person(String name,Physic physic) {
        this.name = name;
        this.physic = physic;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public Person(String name, int age, Date dateDeNaissance) {
     
        this.name = name;
        this.age = age;
        this.dateDeNaissance = dateDeNaissance;

    }

    public Person(){

        super();

    }

There's two options for you:

- `getFormHTML (String action , String method , String... ignore)`:
    Each label for the form is the field's default name

- `getFormHTMLSpecified (String action ,String method ,String [] fieldsName , String ... ignore)`: 
    You can specify each label for the form



case 1:

    new Person().getFormHTML( "Treatment.jsp", "GET")

case 2:

    new Person().getFormHTML( "Treatment.jsp", "GET", new String []{"dateDeNaissance","age"})

case 3

    new Person().getFormHTML( "Treatment.jsp", "GET", "dateDeNaissance","age")

case 4

    new Person().getFormHTMLSpecified("traitement", "get" , 
         new String[] { "Nom","Age" , "Est disponible" } ,"dateDeNaissance" )

case 5

    new Person().getFormHTMLSpecified("traitement", "get" , 
         new String[] { "Nom","Age" ,"Date de naissance" , "Est disponible" }  )


## Generic sort

> Always extends Generic<T>

case 1 : Similar to `ORDER BY age, name` of SQL

    Person[] ps = new Person[]{
        new Person("Cocou", 19),
        new Person("Sab", 456),
        new Person("ali", 0),
        new Person("bbe", 0),
        new Person("John", 25),
        new Person("Alice", 30),
        new Person("Bob", 21)
    };

    Person.sort(ps, new String []{"age","name"});

case 2 : sort Person by Person.Physic.weight 

    Person[] pss = new Person[]{
        new Person("Alice", new Physic(12)),
        new Person("Bob", new Physic(10)),
        new Person("Charlie", new Physic(15))
    };


    HashMap <String ,DeepField > map = new HashMap<String ,DeepField>();
    map.put("physic", new DeepField(new String[]{"physic","weight"}));
        
    Person.sort(pss, new String[]{"physic"},map);

case 3 : sort by Person.Physic.weight and Name
           
    HashMap <String ,DeepField > map = new HashMap<String ,DeepField>();
            map.put("physic", new DeepField(new String[]{"physic","weight"}));

    Person.sort(pss, new String[]{"physic","name"},map);


## SUM and AVERAGE

> Always extends Generic<T>

    import generic.util.Generic;

    public class Prix extends Generic<Prix> {
        String id;
        Double prixCoca;
        Double prixChoco;

        public Prix()
        {
        }
        public Prix(Double prixCoca, Double prixChoco) 
        {
            super();

            this.prixCoca = prixCoca;
            this.prixChoco = prixChoco;
        }
    }

Initialisation:

    Prix[] prixList = new Prix[] {
        new Prix(10., 15.),
        new Prix(5., 8.),
        new Prix(12., 20.)
    };

Test sum:

    Prix result = new Prix().sum(prixList, new String[]{"prixCoca","prixChoco"});

> sum prixCoca = result.prixcoca , sum prixChoco = result.prixChoco

Test average:

    Prix p1= new Prix().average(prixList, new String[]{"prixCoca","prixChoco"});

