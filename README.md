## ModelFactory

when i saw my workmates using interface as pojo at first time , i scream it's was a good idea that
a simple java bean can extends beans as more as it want extends.
so i create this modelfactory ,using cglib and it is very simple to use.

### First

you should create a simple interface (or called it model)

```code
    public interface task1 {
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
    ModelFactory.addListener(new ToStringListener());
    task1 task1 = ModelFactory.create(task1.class);
    task1.setName("task1");
    System.out.println(task1);
```
#### want autoMapper ?

make sure your model extends mapper then add MapperListener

```code
    ModelFactory.addListener(new MapperListener());
    ModelFactory.addListener(new ToStringListener());
    task1 task1 = ModelFactory.create(task1.class);
    task1.setName("task1");
    task2 task2 = task1.map(task2.class);
    System.out.println(task2);
```

#### finally 

you can expand your own listener make your model more useful