package com.digimat.showcase.keycaps.view;

import androidx.fragment.app.Fragment;

import com.digimat.showcase.R;

public class keyCatalog  extends Fragment {
    private RecyclerView recyclerView;
    private List<FoodItem> foodList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_keycatalog, container, false);

        recyclerView = view.findViewById(R.id.foodRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        foodList = new ArrayList<>();
        foodList.add(new FoodItem("Ichiraku Ramen", 15.00, 4.5f, R.drawable.ramen));
        foodList.add(new FoodItem("Philadelphia Roll", 9.50, 4.8f, R.drawable.philadelphia_roll));
        foodList.add(new FoodItem("Salmon Sushi", 7.00, 5.0f, R.drawable.salmon_sushi));
        foodList.add(new FoodItem("Miso Soup", 4.50, 4.3f, R.drawable.miso_soup));

        FoodAdapter adapter = new FoodAdapter(foodList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
