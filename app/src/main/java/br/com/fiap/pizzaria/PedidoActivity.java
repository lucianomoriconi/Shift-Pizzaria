package br.com.fiap.pizzaria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.zip.CheckedInputStream;

import br.com.fiap.pizzaria.model.Pedido;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PedidoActivity extends AppCompatActivity {

    @BindView(R.id.cbAtum)
    CheckBox cbAtum;

    @BindView(R.id.cbBacon)
    CheckBox cbBacon;

    @BindView(R.id.cbCalabresa)
    CheckBox cbCalabresa;

    @BindView(R.id.cbMussarela)
    CheckBox cbMussarela;

    @BindView(R.id.rgTamanhoPizza)
    RadioGroup rbTamanhoPizza;

    @BindView(R.id.spTipoPagamento)
    Spinner spTipoPagamento;

    @BindViews({R.id.cbAtum, R.id.cbBacon, R.id.cbBacon, R.id.cbCalabresa, R.id.cbMussarela})
    List<CheckBox> saboresPizza;

    @BindView(R.id.loading)
    View loading;

    @BindView(R.id.ivLoading)
    ImageView ivLoading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        ButterKnife.bind(this);

    }

    @OnClick(R.id.btFecharPedido)
    public void fecharPedido() {
        loading.setVisibility(View.VISIBLE);
        final Pedido meuPedido = new Pedido();
        meuPedido.setTipoPagamento(spTipoPagamento.getSelectedItem().toString());

        List<String> sabores = new ArrayList<>();

        meuPedido.setSabor(sabores);


        switch (rgTamanhoPizza.getCheckedRadioButtonId()) {
            case R.id.rbTamanhoPequena:
                meuPedido.setTamanho(getString(R.string.label_pequena));
                break;
            case R.id.rbTamanhoMedia:
                meuPedido.setTamanho(getString(R.string.label_media));
                break;
            case R.id.rbTamanhoGrande:
                meuPedido.setTamanho(getString(R.string.label_grande));
                break;

            new android.os.Handler().postDelayed(new Runnable() {
                public void run() {
                    Intent finalizarPedido = new  Intent(SplashActivity.this, LoginActivity.class);
                    finalizarPedido.putExtra(Constants.KEY_MEU_PEDIDO, meuPedido);
                    startActivity(finalizarPedido);
                    finish();
                }
            }, 3500);
        }
    }
}