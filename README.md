## Why Models

Models supports base usage of dto ,and it supports more Scalable function 
such like toJson ,toString ,map .All of those function can make your own Models
more useful .

### First

you should create a simple interface (or called it model)

```code
    @Model
    public interface task1{
        public void setName(String name);
        public String getName();
    }

```

#### then using modelfactory create it 

```code
    task1 task1 = ModelFactory.create(task1.class);
    task1.setName("task1");
    System.out.println(task1.getName());
```

#### want have a toString function ?

```code
    @Model
        public interface task1{
            public void setName(String name);
            public String getName();
            @DtoListener(DtoListener = ToStringListener.class)
            public String toString();
        }
```

#### finally 

you can expand your own listener make your models more useful .