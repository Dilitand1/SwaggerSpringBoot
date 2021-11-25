package myapp.listComponents;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MainClassComponent implements IListClass{

    public List<IListClass> myList;

    MainClassComponent(List<IListClass> springList) {
        myList = springList;
    }

    public List<IListClass> getMyList() {
        return myList;
    }
}
