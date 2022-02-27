package uteq.myapplication.Controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.mindorks.placeholderview.PlaceHolderView;
import com.mindorks.placeholderview.annotations.Animate;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import uteq.myapplication.Models.ClasificationResult;
import uteq.myapplication.MyLogs;
import uteq.myapplication.R;

@NonReusable
@Animate(Animate.CARD_TOP_IN_DESC)
@Layout(R.layout.card_result)
public class CardResultManager {

    @View(R.id.resultsCardElement)
    CardView card;

    @View(R.id.platename)
    public TextView platename;

    @View(R.id.precision)
    public TextView precision;

    public ClasificationResult clasificationObject;
    public Context ctx;
    public PlaceHolderView thisPlaceHolderElement;

    public CardResultManager(Context ctx, PlaceHolderView thisPlaceHolderElement, ClasificationResult clasificationObject) {
        this.clasificationObject = clasificationObject;
        this.ctx = ctx;
        this.thisPlaceHolderElement = thisPlaceHolderElement;
    }

    @Resolve
    public void onResolved() {
        platename.setText(this.clasificationObject.getPlateName());
        precision.setText(String.format("Confianza: %.2f%%", this.clasificationObject.getPrecision()));

        //añadir animación a la tarjeta
        card.setAnimation(AnimationUtils.loadAnimation(ctx, R.anim.rigth_to_left));

        int tmpvalue  = (int)(this.clasificationObject.getPrecision());
        MyLogs.info("El valor es de: " + tmpvalue);
        int valueColor = R.color.level_30;
        if(tmpvalue >= 45){
            valueColor = R.color.level_50;
        }
        if(tmpvalue >= 75){
            valueColor = R.color.level_80;
        }
        if(tmpvalue >= 90){
            valueColor = R.color.level_100;
        }
        card.setBackground(ContextCompat.getDrawable(ctx, valueColor));
    }

    @Click(R.id.resultsCardElement)
    public void onLongClick(){
        MyLogs.info("click");
    }
}
