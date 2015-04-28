package edu.delta.jordanschreier.ultimate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivityPhone}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivityPhone}
 * on handsets.
 */
public class ItemDetailFragmentPhone extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContentPhone.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragmentPhone() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContentPhone.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_detailphone, container, false);

        // Show the dummy content as text in a TextView.
        if(mItem.id.equals("1")){
            rootView = inflater.inflate(R.layout.photosphone, container, false);
        }

        if (mItem.id.equals("2")){
            rootView = inflater.inflate(R.layout.tourphone, container, false);
        }

        if(mItem.id.equals("3")){
            ((WebView) rootView.findViewById(R.id.item_detail)).loadUrl(mItem.item_url);
        }

        return rootView;
    }
}
