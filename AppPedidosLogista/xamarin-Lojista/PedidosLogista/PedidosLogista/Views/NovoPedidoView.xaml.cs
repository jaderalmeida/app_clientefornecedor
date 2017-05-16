using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using PedidosLojista.Models;
using PedidosLojista.ViewModels;
using Xamarin.Forms;

namespace PedidosLojista
{
	public partial class NovoPedidoView : ContentPage
	{
        public NovoPedidoViewModel ViewModel { get; set; }

        public NovoPedidoView(Pedido pedido)
		{
			InitializeComponent();
            this.ViewModel = new NovoPedidoViewModel(pedido);
            this.BindingContext = this.ViewModel;
		}

        protected override void OnAppearing()
        {
            base.OnAppearing();
            MessagingCenter.Subscribe<Pedido>(this, "Pedido",
            	async (msg) =>
            	{
            var confirma = await DisplayAlert("Salvar Pedido","Deseja mesmo salvar o Pedodp?", "sim", "não");

            if (confirma)
            {
                this.ViewModel.SalvarNovoPedido();
            }
            });

            MessagingCenter.Subscribe<Pedido>(this, "SucessoNovoPedido",
            	(msg) =>
            	{
                    DisplayAlert("Pedido", "Novo Pedido salvo com sucesso!", "ok");
                });

            MessagingCenter.Subscribe<ArgumentException>(this, "FalhaNovoPedido",
            	(msg) =>
            	{
                    DisplayAlert("Pedido", "Falha ao salvar Novo Pedido! Verifique os dados e tente novamente mais tarde!", "ok");
                });
        }

        protected override void OnDisappearing()
        {
        	base.OnDisappearing();
        	MessagingCenter.Unsubscribe<Pedido>(this, "NovoPedido");

        	MessagingCenter.Unsubscribe<Pedido>(this, "SucessoNovoPedido");
        	MessagingCenter.Unsubscribe<ArgumentException>(this, "FalhaNovoPedido");
                }


		void OnButtonClicked(object sender, EventArgs args)
		{
			Navigation.PushAsync(new ListagemView());
		}
	}
}
