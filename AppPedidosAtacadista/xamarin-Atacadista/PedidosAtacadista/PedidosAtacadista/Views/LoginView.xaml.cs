using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using PedidosLojista.Views;
using Xamarin.Forms;

namespace PedidosLojista
{
	public partial class LoginView : ContentPage
	{
		public LoginView()
		{
			InitializeComponent();


			var MyEntry = new Entry { Placeholder = "Username" };

			var MyEntry1 = new Entry { IsPassword = true };

		}

		void OnButtonClicked(object sender, EventArgs args)
		{
			Navigation.PushAsync(new ListagemView());	
		}

	}
}
